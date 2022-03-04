import { Component, OnInit, Inject} from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog'

@Component({
  selector: 'app-confirm-dialog-message',
  templateUrl: './confirm-dialog-message.component.html',
  styleUrls: ['./confirm-dialog-message.component.scss']
})
export class ConfirmDialogMessageComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<ConfirmDialogMessageComponent>,
    @Inject(MAT_DIALOG_DATA) public nombreCompleto:string) { }

  ngOnInit(): void {
  }

  onClickNO():void{
    this.dialogRef.close()
  }
}
