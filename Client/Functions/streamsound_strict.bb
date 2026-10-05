Function streamsound_strict%(arg0$, arg1#, arg2%)
    Local local0$
    Local local1.redirectedsound
    Local local2%
    Local local3.stream
    If (filetype(arg0) <> $01) Then
        createconsolemsg((((("Sound " + chr($22)) + arg0) + chr($22)) + " not found."), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        If (consoleopening <> 0) Then
            consoleopen = $01
        EndIf
        Return $00
    EndIf
    local0 = lower(arg0)
    For local1 = Each redirectedsound
        If (local0 = local1\Field2) Then
            local2 = (Int local1\Field1)
            Exit
        EndIf
    Next
    local3 = (New stream)
    local3\Field0 = fsound_stream_open(arg0, arg2, $00, $00)
    local3\Field2 = (Str local2)
    If (local3\Field0 = $00) Then
        createconsolemsg(((("Failed to stream Sound (returned 0): " + chr($22)) + arg0) + chr($22)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        If (consoleopening <> 0) Then
            consoleopen = $01
        EndIf
        Return $00
    EndIf
    local3\Field1 = fsound_stream_play($FFFFFFFF, local3\Field0)
    If (local3\Field1 = $FFFFFFFF) Then
        createconsolemsg(((("Failed to stream Sound (returned -1): " + chr($22)) + arg0) + chr($22)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        If (consoleopening <> 0) Then
            consoleopen = $01
        EndIf
        Return $FFFFFFFF
    EndIf
    fsound_setvolume(local3\Field1, (Int (arg1 * 255.0)))
    fsound_setpaused(local3\Field1, $00)
    local3\Field3 = arg1
    local3\Field4 = -999.0
    Return (Handle local3)
    Return $00
End Function
