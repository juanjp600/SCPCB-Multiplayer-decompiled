Function checkroomoverlap%(arg0.rooms, arg1.rooms)
    If ((((arg1\Field57 >= arg0\Field60) Or (arg1\Field58 >= arg0\Field61)) Or (arg1\Field59 >= arg0\Field62)) <> 0) Then
        Return $00
    EndIf
    If ((((arg1\Field60 <= arg0\Field57) Or (arg1\Field61 <= arg0\Field58)) Or (arg1\Field62 <= arg0\Field59)) <> 0) Then
        Return $00
    EndIf
    Return $01
    Return $00
End Function
