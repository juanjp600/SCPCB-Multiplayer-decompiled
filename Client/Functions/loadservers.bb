Function loadservers%()
    Local local0%
    For local0 = $00 To $14 Step $01
        mp_addlistserver("127.0.0.1", ($98BC + local0), $00)
    Next
    Return $00
End Function
