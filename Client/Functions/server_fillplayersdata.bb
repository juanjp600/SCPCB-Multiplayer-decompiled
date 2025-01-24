Function server_fillplayersdata%()
    Local local0.mp_player
    mp_flushbuffer(mp_getdatabuffer())
    For local0 = Each mp_player
        local0\Field21 = ((((((local0\Field29 + ((1.01 <= local0\Field28) Shl $01)) + ((2.0 <= local0\Field28) Shl $02)) + (local0\Field30 Shl $03)) + ((local0\Field26 > $00) Shl $04)) + ((local0\Field31 = $01) Shl $05)) + ((local0\Field31 = $02) Shl $06))
        blitz_mp_writebyte0(mp_getdatabuffer(), local0\Field5)
        blitz_mp_writebyte0(mp_getdatabuffer(), local0\Field17)
        blitz_mp_writebyte0(mp_getdatabuffer(), local0\Field21)
        blitz_mp_writefloat0(mp_getdatabuffer(), local0\Field7)
        blitz_mp_writefloat0(mp_getdatabuffer(), local0\Field8)
        blitz_mp_writefloat0(mp_getdatabuffer(), local0\Field9)
        blitz_mp_writeshort0(mp_getdatabuffer(), convertfloattoshort(local0\Field10, 10.0))
        blitz_mp_writeshort0(mp_getdatabuffer(), convertfloattoshort(local0\Field11, 10.0))
        blitz_mp_writebyte0(mp_getdatabuffer(), local0\Field14)
        blitz_mp_writebyte0(mp_getdatabuffer(), local0\Field22)
        If (local0\Field26 > $00) Then
            blitz_mp_writeshort0(mp_getdatabuffer(), local0\Field26)
        EndIf
    Next
    blitz_mp_writebyte0(mp_getdatabuffer(), $00)
    Return $00
End Function
