Function mp_client_receivevoice%(arg0.mp_player)
    Local local0%
    Local local1%
    If (arg0 = Null) Then
        Return $00
    EndIf
    local0 = mp_readbyte()
    local1 = createbank(blitz_mp_getbufferavail0())
    mp_readbytes(local1, blitz_mp_getbufferavail0(), $00)
    receiveplayervoice(arg0, local1, local0)
    freebank(local1)
    local1 = $00
    Return $00
End Function
