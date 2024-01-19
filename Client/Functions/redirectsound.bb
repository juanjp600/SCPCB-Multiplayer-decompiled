Function redirectsound.redirectedsound(arg0$, arg1$, arg2%)
    Local local0%
    Local local1%
    Local local2.sound
    Local local3.soundtodelete
    Local local4.stream
    Local local5.redirectedsound
    For local2 = Each sound
        If (lower(local2\Field1) = lower(arg0)) Then
            local3 = (New soundtodelete)
            local3\Field0 = local2\Field0
            local2\Field1 = arg1
            local2\Field4 = $00
            If (local2\Field0 <> $00) Then
                local2\Field0 = loadsound(local2\Field1)
            EndIf
            If (enablesfxrelease = $00) Then
                If (local2\Field0 = $00) Then
                    local2\Field0 = loadsound(local2\Field1)
                EndIf
            EndIf
        EndIf
    Next
    For local4 = Each stream
        If (lower(local4\Field2) = lower(arg0)) Then
            If (local4\Field0 <> $00) Then
                fsound_stopsound(local4\Field1)
                fsound_stream_stop(local4\Field0)
                fsound_stream_close(local4\Field0)
            EndIf
            local4\Field0 = fsound_stream_open(arg1, $02, $00, $00)
            local4\Field1 = fsound_stream_play($FFFFFFFF, local4\Field0)
            fsound_setvolume(local4\Field1, (Int (local4\Field3 * 255.0)))
            fsound_setpaused(local4\Field1, local4\Field5)
            If (-999.0 <> local4\Field4) Then
                fsound_setpan(local4\Field1, (Int local4\Field4))
            EndIf
            local4\Field2 = arg1
        EndIf
    Next
    local5 = (New redirectedsound)
    local5\Field0 = arg0
    local5\Field2 = lower(arg1)
    local5\Field1 = arg1
    local5\Field3 = $01
    Return local5
    Return Null
End Function
