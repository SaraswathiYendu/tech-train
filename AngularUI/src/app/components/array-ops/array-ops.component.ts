import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-array-ops',
  templateUrl: './array-ops.component.html',
  styleUrls: ['./array-ops.component.css']
})
export class ArrayOpsComponent implements OnInit {
  nums:number[]=[4,2,7,1,6,9,8,3];
  numsTemp: number[] =[4,2,7,1,6,9,8,3];

  constructor() { }

  ngOnInit(): void {
  }

  filterArray(op){
    switch(op){
      case 'even':
        this.nums = this.numsTemp;
        this.nums = this.nums.filter(n=>n%2==0);
        break;
      case 'odd':
        this.nums = this.numsTemp;
        this.nums = this.nums.filter(n=>n%2==1);
        break;
      case 'reset':
        this.nums = this.numsTemp;
        break;

    }
  }

}
