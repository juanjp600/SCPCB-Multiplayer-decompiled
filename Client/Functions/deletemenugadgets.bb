Function deletemenugadgets%()
    Local local0.menubutton
    Local local1.menupalette
    Local local2.menutick
    Local local3.menuinputbox
    Local local4.menuslidebar
    Local local5.menuslider
    Local local6.menutextbox
    For local0 = Each menubutton
        deletemenubutton(local0)
    Next
    For local1 = Each menupalette
        deletemenupallete(local1)
    Next
    For local2 = Each menutick
        deletemenutick(local2)
    Next
    For local3 = Each menuinputbox
        deletemenuinputbox(local3)
    Next
    For local4 = Each menuslidebar
        deletemenuslidebar(local4)
    Next
    For local5 = Each menuslider
        deletemenuslider(local5)
    Next
    For local6 = Each menutextbox
        deletemenutextbox(local6)
    Next
    Return $00
End Function
