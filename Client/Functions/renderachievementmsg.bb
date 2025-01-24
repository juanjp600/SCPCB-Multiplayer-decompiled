Function renderachievementmsg%()
    Local local0.achievementmsg
    Local local1.achievementmsg
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    If (((selecteddifficulty\Field0 = difficulties[$03]\Field0) Lor (opt\Field32 = $00)) <> 0) Then
        Return $00
    EndIf
    catcherrors("RenderAchievementMsg")
    local2 = (Int (351.0 * menuscale))
    local3 = (Int (111.0 * menuscale))
    local4 = (Int (85.0 * menuscale))
    local5 = (Int (10.0 * menuscale))
    For local0 = Each achievementmsg
        If (0.0 <> local0\Field3) Then
            local6 = (Int ((Float opt\Field46) + local0\Field2))
            local7 = $00
            For local1 = Each achievementmsg
                If (local1 <> local0) Then
                    If (local1\Field4 > local0\Field4) Then
                        local7 = (local7 + local3)
                    EndIf
                EndIf
            Next
            renderframe(local6, local7, local2, local3, $00, $00, $00)
            color($00, $00, $00)
            rect((local6 + local5), (local7 + local5), local4, local4, $01)
            drawblock(local0\Field5, (local6 + local5), (local7 + local5), $00)
            color($32, $32, $32)
            rect((local6 + local5), (local7 + local5), local4, local4, $00)
            color($FF, $FF, $FF)
            setfontex(fo\Field0[$00])
            rowtext(format(getlocalstring("msg", "achv.unlocked"), local0\Field0, "%s"), (Int ((111.0 * menuscale) + (Float local6))), (local7 + local5), (Int ((Float local2) - (125.0 * menuscale))), (Int ((Float local7) - (26.0 * menuscale))), $00, 1.0)
        EndIf
    Next
    catcherrors("Uncaught: RenderAchievementMsg")
    Return $00
End Function
