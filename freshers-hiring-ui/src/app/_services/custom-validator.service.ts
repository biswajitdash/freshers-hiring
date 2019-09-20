import { Injectable } from '@angular/core';
import { FormControl,  ValidatorFn, AbstractControl, Validators } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class CustomValidatorService {

  constructor() { }

  static marksRangeValidator(control: AbstractControl): { [key: string]: boolean } | null {
    
    if(control.value == ''){
      if(control.parent != undefined){
        control.parent.get('gradeSystem').clearValidators();
        control.parent.get('gradeSystem').updateValueAndValidity();
      }
      return null;
    }
    if(control.value >= 0 && control.value <= 100){
      control.parent.get('gradeSystem').setValidators([Validators.required]);
      control.parent.get('gradeSystem').updateValueAndValidity();
     return null;
      //return { 'range': false };
    }else{
      return { 'range': true };
    }
    
  }
  static requiredGrade(control: AbstractControl): { [key: string]: boolean } | null {
    
    console.log("value "+ control.value);
   
    
    if(control.parent!=undefined){
        console.log(control.parent.value);
        let gradeTemp = control.parent.value.gradeSystem;
        console.log('grade'+ gradeTemp);
        if(gradeTemp == ''){
          console.log("in if");
          return { 'requiredGrade': false };
        }else if(gradeTemp == '' && control.value == ''){
          console.log("in else");
          return { 'requiredGrade': false };
        }
    }
  
      return null;
  
    
  }



}
