Function giveachievement%(arg0$, arg1%)
    If (s2imapcontains(unlockedachievements, arg0) <> 0) Then
        Return $00
    EndIf
    s2imapset(unlockedachievements, arg0, $01)
    If ((opt\Field30 And arg1) <> 0) Then
        createachievementmsg(arg0)
    EndIf
    Return $00
End Function
