Function canuseitem%(arg0%, arg1%, arg2%)
    If (((arg0 = $00) And wearinghazmat) <> 0) Then
        msg = "You can't use that item while wearing a hazmat suit."
        msgtimer = 350.0
        Return $00
    ElseIf (((arg1 = $00) And (wearinggasmask Or wearing1499)) <> 0) Then
        msg = "You can't use that item while wearing a gas mask."
        msgtimer = 350.0
        Return $00
    ElseIf (((arg2 = $00) And wearingnightvision) <> 0) Then
        msg = "You can't use that item while wearing headgear."
        msgtimer = 350.0
        Return $00
    EndIf
    Return $01
    Return $00
End Function
