Function ongetrichpresencejoin%(arg0%, arg1%, arg2%)
    Local local0$
    Local local1%
    Local local2$
    Local local3%
    If (richjoinlobbyrequest = $00) Then
        richjoinlobbyrequest = bp_getfunctionpointer()
        Return $00
    EndIf
    local0 = ""
    For local1 = $00 To $FF Step $01
        If (bs_memory_peekbyte((arg0 + $08), local1) <> $00) Then
            local0 = (local0 + chr(bs_memory_peekbyte((arg0 + $08), local1)))
        EndIf
    Next
    If (local0 <> "") Then
        local2 = dottedip((Int piece(local0, $01, ":")))
        local3 = (Int dottedip((Int piece(local0, $02, ":"))))
        multiplayer_connectto(local2, local3, "", $00, $1388)
    EndIf
    Return $00
End Function
