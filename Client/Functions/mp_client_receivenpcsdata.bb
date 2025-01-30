Function mp_client_receivenpcsdata%()
    Local local0%
    Local local1%
    Local local2%
    Local local3.npcs
    chs\Field2 = mp_readbyte()
    me\Field57 = mp_readbyte()
    mtftimer = mp_readfloat()
    local0 = mp_readbyte()
    local1 = mp_readbyte()
    i_035\Field0 = mp_readbyte()
    Repeat
        local2 = mp_readbyte()
        If (local2 = $00) Then
            Exit
        EndIf
        mp_client_receivenpc(local2)
    Forever
    n_i\Field8 = mp_npcs[local0]
    n_i\Field9 = mp_npcs[local1]
    For local3 = Each npcs
        If (((local3\Field73 = $00) And (local3\Field97 = $00)) <> 0) Then
            If (mp_events[local3\Field69] = Null) Then
                removenpc(local3)
            Else
                local3\Field74 = -9999.0
                local3\Field75 = -9999.0
                local3\Field76 = -9999.0
                local3\Field26 = 1.0
                local3\Field10 = 0.0
            EndIf
        Else
            local3\Field73 = $00
        EndIf
    Next
    npcs_hasreceive = $01
    Return $00
End Function
