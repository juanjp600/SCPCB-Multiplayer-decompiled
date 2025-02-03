Function playannouncement%(arg0$, arg1%)
    If (((mp_getsocket() <> $00) And arg1) <> 0) Then
        mp_synchronizesound(arg0, $02, Null, 10.0, 1.0, 0.0, 0.0, 0.0)
    EndIf
    If (playerinreachableroom($01, $01) = $00) Then
        Return $00
    EndIf
    If (intercomstreamchn <> $00) Then
        stopstream_strict(intercomstreamchn)
        intercomstreamchn = $00
    EndIf
    intercomstreamchn = streamsound_strict(arg0, (opt\Field21 * opt\Field16), 0.0)
    Return $00
End Function
