Function loadachievementsfile%()
    Local local0$
    If (filetype((getenv("AppData") + "\scpcb-mr\Data\Does the Black Moon howl.cb")) <> $01) Then
        Return $00
    EndIf
    local0 = (Str openfile((getenv("AppData") + "\scpcb-mr\Data\Does the Black Moon howl.cb")))
    If (readbyte((Int local0)) <> 0) Then
        s2imapset(unlockedachievements, "keter", $01)
    EndIf
    If (readbyte((Int local0)) <> 0) Then
        s2imapset(unlockedachievements, "apollyon", $01)
    EndIf
    If (readbyte((Int local0)) <> 0) Then
        snavunlocked = $01
    EndIf
    If (readbyte((Int local0)) <> 0) Then
        ereaderunlocked = $01
    EndIf
    closefile((Int local0))
    Return $00
End Function
