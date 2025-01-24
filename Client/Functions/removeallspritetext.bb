Function removeallspritetext%()
    Local local0.spritefont
    For local0 = Each spritefont
        removespritetext(local0)
    Next
    Return $00
End Function
