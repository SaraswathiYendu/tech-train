import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-toggle',
  templateUrl: './toggle.component.html',
  styleUrls: ['./toggle.component.css']
})
export class ToggleComponent implements OnInit {

  showAddress: boolean = false;
  lblButton:string = 'Show Address';

  constructor() { }

  ngOnInit(): void {
  }

  toggleAddress(){
    this.showAddress = !this.showAddress;
    if(this.showAddress == true)
        this.lblButton='Hide Address';
    else
        this.lblButton='Show Address';
  }

}
