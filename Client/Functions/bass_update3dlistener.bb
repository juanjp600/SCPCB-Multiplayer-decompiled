Function bass_update3dlistener%(arg0%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    local0 = createbank($0C)
    pokefloat(local0, $00, entityx(arg0, $01))
    pokefloat(local0, $04, entityy(arg0, $01))
    pokefloat(local0, $08, entityz(arg0, $01))
    tformvector(0.0, 0.0, 1.0, arg0, $00)
    local1 = createbank($0C)
    pokefloat(local1, $00, tformedx())
    pokefloat(local1, $04, tformedy())
    pokefloat(local1, $08, tformedz())
    tformvector(0.0, 1.0, 0.0, arg0, $00)
    local2 = createbank($0C)
    pokefloat(local2, $00, tformedx())
    pokefloat(local2, $04, tformedy())
    pokefloat(local2, $08, tformedz())
    local3 = bass_set3dpositionpos_(local0, $00, local1, local2)
    freebank(local0)
    local0 = $00
    freebank(local1)
    local1 = $00
    freebank(local2)
    local2 = $00
    Return local3
    Return $00
End Function
