Function canuseitem%(arg0%, arg1%, arg2%)
    If (arg1 = $00) Then
        If ((wearinggasmask Or wearing1499) <> 0) Then
            setmsg("You can't use that item while wearing a gas mask.")
            Return $00
        EndIf
    EndIf
    If (arg2 = $00) Then
        If (wearingnightvision <> 0) Then
            setmsg("You can't use that item while wearing headgear.")
            Return $00
        EndIf
    EndIf
    If (arg0 = $00) Then
        If (wearinghazmat <> 0) Then
            setmsg("You can't use that item while wearing a hazmat suit.")
            Return $00
        EndIf
    EndIf
    Return $01
    Return $00
End Function
