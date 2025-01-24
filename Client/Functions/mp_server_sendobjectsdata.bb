Function mp_server_sendobjectsdata%(arg0%)
    Local local0%
    Local local1.mp_roomobject
    Local local2.levers
    Local local3.mp_roomlever
    Local local4.mp_player
    mp_flushbuffer(mp_getdatabuffer())
    If (arg0 = $07) Then
        local0 = $00
        For local1 = Each mp_roomobject
            If (local1\Field15 <> 0) Then
                local0 = local1\Field0\Field11[local1\Field1]
                If (local0 <> $00) Then
                    blitz_mp_writebyte0(mp_getdatabuffer(), local1\Field0\Field31)
                    blitz_mp_writebyte0(mp_getdatabuffer(), local1\Field1)
                    blitz_mp_writebyte0(mp_getdatabuffer(), local1\Field14)
                    If (readbool(local1\Field14, $00) <> 0) Then
                        blitz_mp_writefloat0(mp_getdatabuffer(), entityx(local0, $01))
                    EndIf
                    If (readbool(local1\Field14, $01) <> 0) Then
                        blitz_mp_writefloat0(mp_getdatabuffer(), entityy(local0, $01))
                    EndIf
                    If (readbool(local1\Field14, $02) <> 0) Then
                        blitz_mp_writefloat0(mp_getdatabuffer(), entityz(local0, $01))
                    EndIf
                    If (readbool(local1\Field14, $03) <> 0) Then
                        blitz_mp_writeshort0(mp_getdatabuffer(), convertfloattoshort(entitypitch(local0, $01), 10.0))
                    EndIf
                    If (readbool(local1\Field14, $04) <> 0) Then
                        blitz_mp_writeshort0(mp_getdatabuffer(), convertfloattoshort(entityyaw(local0, $01), 10.0))
                    EndIf
                    If (readbool(local1\Field14, $05) <> 0) Then
                        blitz_mp_writeshort0(mp_getdatabuffer(), convertfloattoshort(entityroll(local0, $01), 10.0))
                    EndIf
                EndIf
            EndIf
        Next
    Else
        For local3 = Each mp_roomlever
            If (local3\Field9 <> 0) Then
                local2 = local3\Field0\Field13[local3\Field1]
                If (local2 <> Null) Then
                    blitz_mp_writebyte0(mp_getdatabuffer(), local3\Field0\Field31)
                    blitz_mp_writebyte0(mp_getdatabuffer(), local3\Field1)
                    blitz_mp_writebyte0(mp_getdatabuffer(), local3\Field8)
                    If (readbool(local3\Field8, $00) <> 0) Then
                        blitz_mp_writeshort0(mp_getdatabuffer(), convertfloattoshort(entitypitch(local2\Field0, $01), 10.0))
                    EndIf
                    If (readbool(local3\Field8, $01) <> 0) Then
                        blitz_mp_writeshort0(mp_getdatabuffer(), convertfloattoshort(entityyaw(local2\Field0, $01), 10.0))
                    EndIf
                    If (readbool(local3\Field8, $02) <> 0) Then
                        blitz_mp_writeshort0(mp_getdatabuffer(), convertfloattoshort(entityroll(local2\Field0, $01), 10.0))
                    EndIf
                EndIf
            EndIf
        Next
    EndIf
    blitz_mp_writebyte0(mp_getdatabuffer(), $00)
    For local4 = Each mp_player
        If (local4\Field5 > $01) Then
            mp_writebyte($06)
            mp_writebyte(arg0)
            mp_writebuffer(mp_getdatabuffer(), $00)
            mp_send(local4\Field0, local4\Field1)
        EndIf
    Next
    Return $00
End Function
