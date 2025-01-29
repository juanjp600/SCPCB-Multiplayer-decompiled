Function saveachievementsfile%()
    Local local0$
    local0 = (Str writefile((getenv("AppData") + "\scpcb-mr\Data\Does the Black Moon howl.cb")))
    writebyte((Int local0), s2imapcontains(unlockedachievements, "keter"))
    writebyte((Int local0), s2imapcontains(unlockedachievements, "apollyon"))
    writebyte((Int local0), snavunlocked)
    writebyte((Int local0), ereaderunlocked)
    closefile((Int local0))
    Return $00
End Function
