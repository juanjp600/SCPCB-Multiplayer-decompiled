Function mp_receiverequestedinfo%()
    Local local0%
    Local local1%
    Local local2%
    local0 = mp_readbyte()
    local1 = local0
    If (local1 = $01) Then
        mp_decompressbuffer(getnetworkreadbuffer())
        Repeat
            local2 = mp_readbyte()
            If (local2 = $00) Then
                Exit
            EndIf
            mp_receivedplayerinfo(ue_players[local2])
        Forever
    EndIf
    Return $00
End Function
