Function clearplayertag%(arg0.mp_player, arg1%)
    If (arg0\Field34[arg1]\Field1 <> $00) Then
        freeentity(arg0\Field34[arg1]\Field1)
        arg0\Field34[arg1]\Field1 = $00
    EndIf
    Return $01
    Return $00
End Function
