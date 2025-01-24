Function checkroomoverlap%(arg0.rooms, arg1.rooms)
    If ((((arg1\Field23 >= arg0\Field26) Lor (arg1\Field24 >= arg0\Field27)) Lor (arg1\Field25 >= arg0\Field28)) <> 0) Then
        Return $00
    EndIf
    If ((((arg1\Field26 <= arg0\Field23) Lor (arg1\Field27 <= arg0\Field24)) Lor (arg1\Field28 <= arg0\Field25)) <> 0) Then
        Return $00
    EndIf
    Return $01
    Return $00
End Function
