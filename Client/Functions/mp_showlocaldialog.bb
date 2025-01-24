Function mp_showlocaldialog%(arg0$, arg1$, arg2$, arg3$, arg4%, arg5%, arg6%)
    mp_dialog\Field0 = $01
    mp_dialog\Field2 = arg0
    mp_dialog\Field3 = arg1
    mp_dialog\Field4 = arg2
    mp_dialog\Field5 = arg3
    mp_dialog\Field1 = arg4
    mp_dialog\Field10 = arg5
    mp_dialog\Field8 = arg6
    If (arg4 = $01) Then
        mp_dialog\Field7 = $01
    EndIf
    shoulddeletegadgets = $01
    Return $00
End Function
