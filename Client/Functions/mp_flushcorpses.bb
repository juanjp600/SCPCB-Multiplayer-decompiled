Function mp_flushcorpses%()
    Local local0.mp_playercorpse
    For local0 = Each mp_playercorpse
        mp_flushcorpse(local0)
    Next
    Return $00
End Function
