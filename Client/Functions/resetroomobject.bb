Function resetroomobject%(arg0.rooms, arg1%)
    If (arg0\Field32[arg1] <> Null) Then
        arg0\Field32[arg1]\Field15 = $00
    EndIf
    Return $00
End Function
