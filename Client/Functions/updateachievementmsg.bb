Function updateachievementmsg%()
    Local local0.achievementmsg
    Local local1.achievementmsg
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    local2 = (Int (264.0 * achvscale))
    local3 = (Int (84.0 * achvscale))
    local4 = (Int (10.0 * achvscale))
    local5 = (Int (64.0 * achvscale))
    For local0 = Each achievementmsg
        If (0.0 <> local0\Field3) Then
            local6 = (Int (local0\Field2 + (Float graphicwidth)))
            local7 = (graphicheight - local3)
            For local1 = Each achievementmsg
                If (local1 <> local0) Then
                    If (local1\Field4 > local0\Field4) Then
                        local7 = (local7 - local3)
                    EndIf
                EndIf
            Next
            drawframe(local6, local7, local2, local3, $00, $00)
            setcolorex($00, $00, $00)
            rect((local6 + local4), (local7 + local4), local5, local5, $01)
            drawimage(achvimg(local0\Field0), (local6 + local4), (local7 + local4), $00)
            setcolorex($32, $32, $32)
            rect((Int ((10.0 * achvscale) + (Float local6))), (Int ((10.0 * achvscale) + (Float local7))), local5, local5, $00)
            setcolorex($FF, $FF, $FF)
            setfontex(fonts[$00]\Field0)
            rowtext(("Achievement Unlocked - " + local0\Field1), ((84.0 * achvscale) + (Float local6)), (Float (local7 + local4)), ((Float local2) - (94.0 * achvscale)), ((Float local7) - (20.0 * achvscale)), $00, 1.0, $00)
            If (((0.0 < local0\Field3) And (490.0 > local0\Field3)) <> 0) Then
                local0\Field3 = (local0\Field3 + fpsfactor2)
                If ((Float (- local2)) < local0\Field2) Then
                    local0\Field2 = max((local0\Field2 - (4.0 * fpsfactor2)), (Float (- local2)))
                EndIf
            ElseIf (490.0 <= local0\Field3) Then
                local0\Field3 = -1.0
            ElseIf (-1.0 = local0\Field3) Then
                If (0.0 > local0\Field2) Then
                    local0\Field2 = min((local0\Field2 + (4.0 * fpsfactor2)), 0.0)
                Else
                    local0\Field3 = 0.0
                EndIf
            EndIf
        Else
            Delete local0
        EndIf
    Next
    Return $00
End Function
