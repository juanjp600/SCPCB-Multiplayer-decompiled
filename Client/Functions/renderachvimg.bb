Function renderachvimg%(arg0%, arg1%, arg2%, arg3$)
    Local local0%
    Local local1%
    Local local2#
    Local local3%
    Local local4%
    catcherrors("RenderAchvIMG")
    local1 = (arg2 Mod $04)
    local2 = (101.0 * menuscale)
    local3 = (Int (85.0 * menuscale))
    local4 = (Int (((Float local1) * local2) + (Float arg0)))
    color($00, $00, $00)
    rect(local4, arg1, local3, local3, $01)
    If (s2imapcontains(unlockedachievements, arg3) <> 0) Then
        local0 = s2imapget(achievementsimages, arg3)
    Else
        local0 = s2imapget(achievementsimages, "locked")
    EndIf
    drawblock(local0, local4, arg1, $00)
    color($32, $32, $32)
    rect(local4, arg1, local3, local3, $00)
    catcherrors("Uncaught: RenderAchvIMG")
    Return $00
End Function
