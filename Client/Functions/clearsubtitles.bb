Function clearsubtitles%()
    Local local0.subtitlesmsg
    For local0 = Each subtitlesmsg
        Delete local0
    Next
    Return $00
End Function
