import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-array-ops',
  templateUrl: './array-ops.component.html',
  styleUrls: ['./array-ops.component.css']
})
export class ArrayOpsComponent implements OnInit {
  @Input("nums")
  nums:number[];

  @Input("temp")
  numsTemp: number[];

  constructor() { }

  ngOnInit(): void {
    this.numsTemp = [...this.nums];
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
