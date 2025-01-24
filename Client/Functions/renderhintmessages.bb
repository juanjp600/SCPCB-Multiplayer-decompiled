Function renderhintmessages%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    If (((selecteddifficulty\Field0 = difficulties[$03]\Field0) Lor (opt\Field32 = $00)) <> 0) Then
        Return $00
    EndIf
    local0 = (Int ((Float stringwidth(msg\Field6)) + (20.0 * menuscale)))
    local1 = (Int (30.0 * menuscale))
    local2 = (mo\Field9 - (local0 Sar $01))
    local3 = (Int (msg\Field8 + (Float (- local1))))
    If (msg\Field6 <> "") Then
        renderframe(local2, local3, local0, local1, $00, $00, $00)
        color($FF, $FF, $FF)
        setfontex(fo\Field0[$00])
        textex(mo\Field9, ((local1 Sar $01) + local3), msg\Field6, $01, $01)
    EndIf
    Return $00
End Function
