Function initializeplayertags%(arg0.mp_player)
    Local local0%
    For local0 = $00 To $04 Step $01
        arg0\Field34[local0] = (New mp_playertag)
    Next
    Return $00
End Function
