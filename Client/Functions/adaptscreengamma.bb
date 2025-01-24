Function adaptscreengamma%()
    If (1.0 >= opt\Field6) Then
        Return $00
    EndIf
    opt\Field7 = opt\Field6
    opt\Field6 = 1.0
    Return $00
End Function
