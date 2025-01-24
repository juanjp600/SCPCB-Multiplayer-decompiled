Function updatemouseinput%()
    Local local0%
    mouseposx = (Float mousex())
    mouseposy = (Float mousey())
    If (0.0 < input_resettime) Then
        input_resettime = max((input_resettime - fps\Field7[$01]), 0.0)
    Else
        mo\Field3 = $00
        mo\Field0 = mousehit($01)
        If (mo\Field0 <> 0) Then
            If ((millisecs() - mo\Field5) < $12C) Then
                mo\Field3 = $01
            EndIf
            mo\Field5 = millisecs()
        EndIf
        local0 = mo\Field2
        mo\Field2 = mousedown($01)
        mo\Field6 = (local0 And (mo\Field2 = $00))
        mo\Field1 = mousehit($02)
    EndIf
    Return $00
End Function
