import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormArray, AbstractControl, FormControl } from '@angular/forms';
import { first } from 'rxjs/operators';
import { FresherInfoService } from 'src/app/_services/fresher-info.service';
import { MessageComponent } from '../message/message.component';
import { MatDialog, MatDialogRef } from  '@angular/material';
import { stringify } from 'querystring';
import { CustomValidatorService } from '../../_services/custom-validator.service';

@Component({
  selector: 'app-freshers-info',
  templateUrl: './freshers-info.component.html',
  styleUrls: ['./freshers-info.component.css']
})
export class FreshersInfoComponent implements OnInit {
  fresherForm: FormGroup;
  submitted = false;
  responseObj:any;
  configData:any;
  qualificationList:[];
  competitiveExamList:[]

  constructor(
    private formBuilder: FormBuilder,
    private fresherInfoService: FresherInfoService,
    private cd: ChangeDetectorRef,
    private  dialog:  MatDialog
  ) { }

  gradeSystemList = [ {id: 'percentage', name: 'Percentage'},
                      {id: 'cgpa', name: 'CGPA'}
                    ];
 // years = ['2015','2016','2017','2018','2019','2020','2021','2022','2023','2024','2025','2026','2027','2028','2029','2030'];                  
  
  //competitiveExamList = ['GATE', 'CET', 'COMEDK', 'JEE Main', 'JEE'];

  //qualificationList = ['BEorBTECH', 'MTECH', 'PHD'];

  public getConfigurations(){
    this.fresherInfoService.getConfigurations().pipe(first()).subscribe(

              data=>{
                this.configData = data;
                this.qualificationList = this.configData.exams;
                this.competitiveExamList =this.configData.competitiveExams;
                console.log("Data fetch from API", this.configData);
              },
              error=>{
                 console.log("Error", error); 
              }
    );    
    
  }


  ngOnInit() {

    this.getConfigurations();

    this.fresherForm = this.formBuilder.group({
      name: ['', Validators.required],
      surname: ['',  Validators.required],
      email: ['',  [Validators.required, Validators.email]],
      dateOfBirth: ['', Validators.required],
      mobileNo: ['',  [Validators.required]],
      highestQualification: ['',  Validators.required],
      educationDetails: this.formBuilder.array([this.formBuilder.group(
                                                {
                                                  exam:[{examId: '1', examName: 'SSC'}, [Validators.required]],
                                                  marks: ['', [Validators.required, CustomValidatorService.marksRangeValidator]], 
                                                  marksPercentage: '',
                                                  gradeSystem: [''], 
                                                  yearPassing: ['', [Validators.required]], 
                                                  labelMark:'10th %marks or CGPA*'
                                                }
                                                )]),
      competitives: this.formBuilder.array([this.formBuilder.group(
                                                {
                                                  competitiveExam: new FormGroup({
                                                    competitiveExamId: new FormControl(''),
                                                  }),
                                                  marksScorePercentage:'',
                                                  examRank:'', 
                                                  yearAppeared: ''
                                                }
                                              )]),
      projectDescription: ['',  Validators.required],
      resume: ['', Validators.required], 
      legalConsent: [true,  Validators.required]
    });

    this.educationDetails.push(this.formBuilder.group(
                                                      {
                                                        exam:{examId: '2', examName: 'HSC'}, 
                                                        marks:['', [Validators.required,
                                                          CustomValidatorService.marksRangeValidator]],
                                                        marksPercentage: '',
                                                        gradeSystem: '',
                                                        yearPassing: ['', [Validators.required]], 
                                                        labelMark:'12th %marks or CGPA*'
                                                      }));
    this.educationDetails.push(this.formBuilder.group(
                                                      {
                                                        exam:{examId: '3', examName: 'BEorBTECH'}, 
                                                        marks:['', [Validators.required, 
                                                          CustomValidatorService.marksRangeValidator]],  
                                                        marksPercentage: '', 
                                                        gradeSystem: '', 
                                                        yearPassing: ['', [Validators.required]], 
                                                        labelMark:'BE/B.Tech %marks or CGPA*'
                                                      }));
    this.educationDetails.push(this.formBuilder.group(
                                                      {
                                                        exam:{examId: '4', examName: 'MTECH'}, 
                                                        marks:['',[CustomValidatorService.marksRangeValidator]], 
                                                        marksPercentage:'', 
                                                        gradeSystem: '', 
                                                        yearPassing: '', 
                                                        labelMark: 'M.Tech/MS %marks or CGPA'
                                                      }));
    this.educationDetails.push(this.formBuilder.group(
                                                      {
                                                        exam:{examId: '5', examName: 'PHD'}, 
                                                        marks:['', [CustomValidatorService.marksRangeValidator]], 
                                                        marksPercentage:'', 
                                                        gradeSystem: '', 
                                                        yearPassing: '', 
                                                        labelMark: 'Phd %marks or CGPA'
                                                      }));
   
 


  

  
  }

 
  get years(){
    let range = [];
    if( this.configData!=undefined && this.configData!=""){
      let initialYear = this.configData.initialYear;
      let maxYears = this.configData.maxYears;
      for (let i = 0; i < maxYears; i++) {
        range.push(initialYear + i);
      }  
    }  
    return range;
  }
  //gradeSystem: this.gradeSystemList[0].id,

  get competitives() {
    return this.fresherForm.get('competitives') as FormArray;
  }

  addCompetitiveExam() {
    this.competitives.push(this.formBuilder.group(
      {
        competitiveExam: new FormGroup({
          competitiveExamId: new FormControl(''),
        }), 
        marksScorePercentage:'',
        examRank:'', 
        yearAppeared: ''
      }));
  }
  deleteCompetitiveExam(index) {
    this.competitives.removeAt(index);
  }
  get educationDetails() {
    return this.fresherForm.get('educationDetails') as FormArray;
  }

  
  currentFileUpload: File;
  selectFile(event) {
    this.currentFileUpload = event.target.files[0];
    this.fresherForm.controls['resume'].setValue(this.currentFileUpload ? this.currentFileUpload.name : '');
  }
  calculatePercents(indx, marksVal , gradeVal){

    const faControl = (<FormArray>this.fresherForm.controls['educationDetails']).at(indx);

    if(gradeVal == 'cgpa'){
      faControl['controls'].marksPercentage.setValue((marksVal*9.5).toFixed(3));
    }else{
      faControl['controls'].marksPercentage.setValue(marksVal);
    }

    // if(marksVal >0 && marksVal <=10){
    //   faControl['controls'].gradeSystem.setValue('cgpa');
    //   faControl['controls'].marksPercentage.setValue((marksVal*9.5).toFixed(3));
    // }else{
    //   faControl['controls'].gradeSystem.setValue('percentage');
    //   faControl['controls'].marksPercentage.setValue(marksVal);
    // }
             
  }
  get eduDtls(): FormArray {
    return this.fresherForm.get('educationDetails') as FormArray;
  }


  public findInvalidControls() {
    const invalid = [];
    const controls = this.fresherForm.controls;
    console.log("Invalid controls are");
    for (const name in controls) {
        if (controls[name].invalid) {
            invalid.push(name);
            console.log(name);
        }
    }
    return invalid;
}

  
  onSubmit() {

      this.submitted = true;
      if(this.fresherForm.invalid){
          return;
      }
      let fresherObj = Object.assign({}, this.fresherForm.value);   
      if(fresherObj.competitives.length>1){
          for(let i =0;i<fresherObj.competitives.length; i++){
            if(fresherObj.competitives[i].competitiveExam.competitiveExamId==''){
              this.dialog.open(MessageComponent,{ data: {
                message:  "Please Select Competitive Exam"
                }});
                return;
            }
          }
      }else{
        if(fresherObj.competitives[0].competitiveExam.competitiveExamId<1){
          fresherObj.competitives = null;
        }
      }
          
      this.fresherInfoService.submitFresherDetails(this.currentFileUpload, fresherObj)
                .pipe(first())
                .subscribe(
                      data => {
                         this.responseObj = data;
                        if(this.responseObj.code == 200 || this.responseObj.code == 201){
                          this.dialog.open(MessageComponent,{ data: {
                            message:  "Your details send successfully"
                            }});
                           
                        }else{
                          this.dialog.open(MessageComponent,{ data: {
                            message:  "Details not sent. Please try again later"
                            }});
                        }
                      },
                      error => {
                        this.dialog.open(MessageComponent,{ data: {
                          message:  "Details not sent. Please try again later"
                          }});                  
                      }  
                );
    }
}
