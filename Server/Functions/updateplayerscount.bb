Function updateplayerscount%()
    Local local0%
    For local0 = $01 To server\Field11 Step $01
        checkplayertimeout(playeroptimize[local0])
    Next
    Return $00
End Function
