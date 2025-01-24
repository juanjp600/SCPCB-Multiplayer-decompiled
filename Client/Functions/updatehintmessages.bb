Function updatehintmessages%()
    Local local0%
    If (((selecteddifficulty\Field0 = difficulties[$03]\Field0) Lor (opt\Field32 = $00)) <> 0) Then
        Return $00
    EndIf
    local0 = (Int (30.0 * menuscale))
    If (msg\Field6 <> "") Then
        If (0.0 < msg\Field7) Then
            msg\Field8 = min((msg\Field8 + (fps\Field7[$00] * 2.0)), (Float local0))
            msg\Field7 = (msg\Field7 - fps\Field7[$00])
        ElseIf (0.0 < msg\Field8) Then
            msg\Field8 = max((msg\Field8 - (fps\Field7[$00] * 2.0)), 0.0)
        Else
            msg\Field6 = ""
            msg\Field7 = 0.0
            msg\Field8 = 0.0
        EndIf
    EndIf
    Return $00
End Function
