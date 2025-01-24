Function flushplayertags%(arg0.mp_player)
    Local local0%
    For local0 = $00 To $04 Step $01
        clearplayertag(arg0, local0)
        Delete arg0\Field34[local0]
    Next
    Return $01
    Return $00
End Function
