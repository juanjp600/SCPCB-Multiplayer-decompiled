Function mp_server_receivevoice%(arg0.mp_player)
    Local local0%
    If (determinepacketflooding(arg0, $01, $28, $3E8) <> 0) Then
        Return $00
    EndIf
    local0 = createbank(blitz_mp_getbufferavail0())
    mp_readbytes(local0, blitz_mp_getbufferavail0(), $00)
    receiveplayervoice(arg0, local0, arg0\Field4\Field26)
    mp_serverbroadcastvoice(arg0, 180.0, local0, arg0\Field4\Field26)
    freebank(local0)
    local0 = $00
    Return $00
End Function
