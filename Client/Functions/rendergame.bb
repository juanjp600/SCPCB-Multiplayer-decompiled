Function rendergame%()
    catcherrors("RenderGame()")
    rendertween = max(0.0, ((fps\Field0 / 1.166667) + 1.0))
    If (((0.0 < fps\Field7[$00]) And playerinreachableroom($00, $01)) <> 0) Then
        rendersecuritycams()
    EndIf
    renderworldex(rendertween)
    renderblur(me\Field48)
    rendernvg()
    rendergui()
    rendermessages()
    renderhintmessages()
    rendersubtitles()
    renderconsole()
    renderquickloading()
    renderachievementmsg()
    If (0.0 > me\Field45) Then
        If (me\Field43 <> $FFFFFFFF) Then
            renderending()
        EndIf
    ElseIf (me\Field43 = $FFFFFFFF) Then
        rendermenu()
    EndIf
    If (mp_getsocket() <> $00) Then
        mp_rendercorpsegui()
        mp_rendergui($08, $01)
        mp_renderterminatedgui()
    EndIf
    catcherrors("Uncaught: RenderGame()")
    Return $00
End Function
