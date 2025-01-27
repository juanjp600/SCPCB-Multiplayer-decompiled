Function mp_client_recvplayersglobaldata%()
    Local local0%
    Local local1.mp_modelmeshpreset
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6$
    Local local7$
    Local local8%
    Local local9.mp_attachmodelpreset
    Repeat
        local0 = mp_readbyte()
        If (local0 = $00) Then
            Exit
        EndIf
        createplayermodelmesh(local0, mp_readline(), $01)
        local1 = getplayermodelmeshpreset(local0)
        local1\Field1 = mp_readline()
        local1\Field0 = mp_readline()
        local1\Field2 = mp_readline()
        local1\Field3 = mp_readline()
        local1\Field8 = mp_readbyte()
        local1\Field10 = convertshorttofloat(mp_readshort(), 10.0)
        local1\Field9 = convertshorttofloat(mp_readshort(), 10.0)
        local1\Field7 = mp_readbyte()
        local1\Field6 = mp_readbyte()
        local1\Field4 = mp_readbyte()
        local1\Field5 = mp_readbyte()
        local1\Field12 = mp_readfloat()
        local1\Field11 = mp_readfloat()
        local1\Field14 = convertshorttofloat(mp_readshort(), 10.0)
        local1\Field15 = convertshorttofloat(mp_readshort(), 10.0)
        local1\Field16 = convertshorttofloat(mp_readshort(), 10.0)
        local1\Field17 = mp_readfloat()
        local1\Field18 = mp_readfloat()
        local1\Field19 = mp_readfloat()
        local1\Field20 = convertshorttofloat(mp_readshort(), 10.0)
        local1\Field21 = convertshorttofloat(mp_readshort(), 10.0)
        local1\Field22 = convertshorttofloat(mp_readshort(), 10.0)
        local1\Field13 = mp_readline()
        Repeat
            local2 = mp_readbyte()
            If (local2 = $00) Then
                Exit
            EndIf
            local1\Field23[local2] = mp_readint()
            local1\Field24[local2] = mp_readfloat()
            local1\Field25[local2] = mp_readfloat()
            local1\Field28[local2] = mp_readbyte()
        Forever
        For local3 = $00 To $03 Step $01
            local1\Field26[local3] = mp_readint()
            local1\Field27[local3] = mp_readfloat()
        Next
        For local3 = $00 To $03 Step $01
            setplayermodelmeshsound(local0, local3, mp_readline())
        Next
    Forever
    Repeat
        local4 = mp_readbyte()
        If (local4 = $00) Then
            Exit
        EndIf
        createplayermodeltexture(local4, mp_readline(), $01)
    Forever
    Repeat
        local5 = mp_readbyte()
        If (local5 = $00) Then
            Exit
        EndIf
        createattachmodel(local5, "", "", $01)
        For local3 = $00 To $03 Step $01
            local6 = mp_readline()
            If (local6 <> "") Then
                local7 = mp_readline()
                setattachmodelvariety(local5, local3, local6, local7)
            EndIf
        Next
        For local3 = $00 To $03 Step $01
            setattachmodelsound(local5, local3, mp_readline())
        Next
        Repeat
            local8 = mp_readbyte()
            If (local8 = $00) Then
                Exit
            EndIf
            local9 = createattachmodelpreset(local5, local8)
            If (local9 <> Null) Then
                local9\Field0 = mp_readline()
                local9\Field4 = convertshorttofloat(mp_readshort(), 10.0)
                local9\Field5 = convertshorttofloat(mp_readshort(), 10.0)
                local9\Field6 = convertshorttofloat(mp_readshort(), 10.0)
                local9\Field1 = convertshorttofloat(mp_readshort(), 10.0)
                local9\Field2 = convertshorttofloat(mp_readshort(), 10.0)
                local9\Field3 = convertshorttofloat(mp_readshort(), 10.0)
                local9\Field7 = mp_readfloat()
                local9\Field8 = mp_readbyte()
            Else
                mp_readline()
                mp_ignorebytes($11)
            EndIf
        Forever
    Forever
    Return $00
End Function
