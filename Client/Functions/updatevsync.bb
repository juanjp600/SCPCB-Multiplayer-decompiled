Function updatevsync%(arg0%)
    If (arg0 = $FFFFFFFF) Then
        flip(verticalsync)
    Else
        flip(arg0)
    EndIf
    Return $00
End Function
