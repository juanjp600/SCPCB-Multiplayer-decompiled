Function breach_countroles%()
    Local local0%
    Local local1%
    Return $00
    For local0 = $00 To (last_breach_type - $01) Step $01
        gameinfo\Field6[local0] = $00
    Next
    For local1 = $01 To server\Field11 Step $01
        gameinfo\Field6[playeroptimize[local1]\Field36] = (gameinfo\Field6[playeroptimize[local1]\Field36] + $01)
    Next
    Return $00
End Function
