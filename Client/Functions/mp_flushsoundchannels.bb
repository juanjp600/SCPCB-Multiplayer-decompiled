Function mp_flushsoundchannels%()
    Local local0.mp_soundchannel
    Local local1.mp_localsoundchannel
    For local0 = Each mp_soundchannel
        mp_flushsoundchannel(local0)
    Next
    For local1 = Each mp_localsoundchannel
        mp_flushlocalsoundchannel(local1)
    Next
    Return $00
End Function
