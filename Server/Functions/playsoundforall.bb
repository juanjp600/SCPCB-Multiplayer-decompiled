Function playsoundforall%(arg0$)
    Local local0%
    For local0 = $01 To server\Field11 Step $01
        playsoundforplayer(playeroptimize[local0]\Field30, arg0)
    Next
    Return $00
End Function
