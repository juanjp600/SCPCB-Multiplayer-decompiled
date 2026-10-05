Function removetimer%(arg0.timers)
    If (arg0 = Null) Then
        Return $00
    EndIf
    If (arg0 = currentscripttimer) Then
        arg0\Field7 = $01
        Return $00
    EndIf
    removebytestream(arg0\Field1)
    Delete arg0
    Return $00
End Function
