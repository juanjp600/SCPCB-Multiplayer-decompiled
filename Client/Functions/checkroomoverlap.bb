Function checkroomoverlap%(arg0.rooms, arg1.rooms)
    If ((((arg1\Field59 >= arg0\Field62) Or (arg1\Field60 >= arg0\Field63)) Or (arg1\Field61 >= arg0\Field64)) <> 0) Then
        Return $00
    EndIf
    If ((((arg1\Field62 <= arg0\Field59) Or (arg1\Field63 <= arg0\Field60)) Or (arg1\Field64 <= arg0\Field61)) <> 0) Then
        Return $00
    EndIf
    Return $01
    Return $00
End Function
