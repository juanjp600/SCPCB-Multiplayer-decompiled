Function gg_space_text_line%(arg0.tgg_textline, arg1$)
    Local local0%
    Local local1#
    Local local2#
    Local local3#
    Local local4#
    Local local5.tgg_character
    Local local6%
    local6 = len(arg1)
    For local0 = $01 To local6 Step $01
        If (local0 > $FA) Then
            Exit
        EndIf
        local5 = gg_find_character(arg0\Field4, mid(arg1, local0, $01))
        If (arg0\Field7 = $01) Then
            local1 = (((((local2 / 2.0) + (local5\Field3 / 2.0)) * 0.035) * arg0\Field6) + local1)
            positionentity(arg0\Field2[local0], local1, 0.0, 0.0, $00)
        Else
            local1 = (local1 - (arg0\Field6 * 1.7))
            positionentity(arg0\Field2[local0], 0.0, local1, 0.0, $00)
        EndIf
        local2 = local5\Field3
    Next
    If (((arg0\Field5 <> $FFFFFFFF) And (arg0\Field7 = $01)) <> 0) Then
        If (arg0\Field5 > $01) Then
            local3 = (Float arg0\Field5)
            local4 = entityx(arg0\Field2[len(arg1)], $00)
            For local0 = $01 To local6 Step $01
                moveentity(arg0\Field2[local0], ((local3 - local4) * ((Float (local0 - $01)) / (Float local6))), 0.0, 0.0)
            Next
        Else
            For local0 = $01 To local6 Step $01
                moveentity(arg0\Field2[local0], ((local1 / 2.0) * (Float ((- arg0\Field5) - $01))), 0.0, 0.0)
            Next
        EndIf
    EndIf
    Return $00
End Function
