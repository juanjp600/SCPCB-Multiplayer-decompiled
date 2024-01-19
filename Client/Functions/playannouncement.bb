Function playannouncement%(arg0$, arg1%, arg2%)
    Local local0%
    If (intercomstreamchn <> $00) Then
        stopstream_strict(intercomstreamchn)
        intercomstreamchn = $00
    EndIf
    If (((playerinreachableroom($00) Or arg2) Or (networkserver\Field15 = $01)) <> 0) Then
        intercomstreamchn = streamsound_strict(arg0, sfxvolume, $00)
    EndIf
    If ((networkserver\Field18 And (arg1 = $01)) <> 0) Then
        For local0 = $01 To networkserver\Field14 Step $01
            If (((player[local0] <> Null) And (local0 <> $01)) <> 0) Then
                udp_writebyte($09)
                udp_writebyte($01)
                udp_writeline(arg0)
                udp_sendmessage(local0)
            EndIf
        Next
    EndIf
    Return $00
End Function
