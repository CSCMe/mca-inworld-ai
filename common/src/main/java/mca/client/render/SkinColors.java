package mca.client.render;

public interface SkinColors {
    ColourPallet PALLET = new ColourPallet(new double[][][] {
            {
                    {0.94509803921569, 0.89411764705882, 0.78823529411765},
                    {0.94117647058824, 0.89019607843137, 0.7843137254902},
                    {0.93333333333333, 0.86666666666667, 0.76862745098039},
                    {0.90980392156863, 0.81960784313725, 0.73725490196078},
                    {0.88235294117647, 0.76078431372549, 0.70196078431373},
                    {0.85098039215686, 0.69411764705882, 0.65882352941176},
                    {0.81960784313725, 0.63529411764706, 0.6156862745098},
                    {0.78823529411765, 0.5843137254902, 0.57647058823529},
                    {0.75686274509804, 0.54117647058824, 0.53333333333333},
                    {0.72549019607843, 0.50588235294118, 0.49411764705882},
                    {0.69411764705882, 0.47058823529412, 0.45882352941176},
                    {0.65882352941176, 0.44313725490196, 0.42352941176471},
                    {0.62745098039216, 0.41960784313725, 0.3921568627451},
                    {0.6, 0.39607843137255, 0.36078431372549},
                    {0.57254901960784, 0.37254901960784, 0.33333333333333},
                    {0.54509803921569, 0.35294117647059, 0.30980392156863},
                    {0.51764705882353, 0.33333333333333, 0.28627450980392},
                    {0.49411764705882, 0.31372549019608, 0.26666666666667},
                    {0.47450980392157, 0.29411764705882, 0.24705882352941},
                    {0.45490196078431, 0.27450980392157, 0.23137254901961},
            },
            {
                    {0.94509803921569, 0.89411764705882, 0.78823529411765},
                    {0.94117647058824, 0.88627450980392, 0.7843137254902},
                    {0.92941176470588, 0.86666666666667, 0.76862745098039},
                    {0.90588235294118, 0.81960784313725, 0.73725490196078},
                    {0.88235294117647, 0.76078431372549, 0.70196078431373},
                    {0.85098039215686, 0.69411764705882, 0.65882352941176},
                    {0.81960784313725, 0.63529411764706, 0.6156862745098},
                    {0.78823529411765, 0.5843137254902, 0.57254901960784},
                    {0.75686274509804, 0.53725490196078, 0.53333333333333},
                    {0.72549019607843, 0.50196078431373, 0.49411764705882},
                    {0.69019607843137, 0.47058823529412, 0.45490196078431},
                    {0.65882352941176, 0.44313725490196, 0.41960784313725},
                    {0.62745098039216, 0.41960784313725, 0.3921568627451},
                    {0.59607843137255, 0.39607843137255, 0.36078431372549},
                    {0.57254901960784, 0.37254901960784, 0.33333333333333},
                    {0.54509803921569, 0.35294117647059, 0.30980392156863},
                    {0.51764705882353, 0.33333333333333, 0.28627450980392},
                    {0.49411764705882, 0.31372549019608, 0.26666666666667},
                    {0.47450980392157, 0.29411764705882, 0.24705882352941},
                    {0.45490196078431, 0.27450980392157, 0.23137254901961},
            },
            {
                    {0.93725490196078, 0.88235294117647, 0.77254901960784},
                    {0.93725490196078, 0.87843137254902, 0.76862745098039},
                    {0.92549019607843, 0.85490196078431, 0.75294117647059},
                    {0.90196078431373, 0.81176470588235, 0.72549019607843},
                    {0.87843137254902, 0.75294117647059, 0.69019607843137},
                    {0.84705882352941, 0.69019607843137, 0.64705882352941},
                    {0.8156862745098, 0.63137254901961, 0.6078431372549},
                    {0.7843137254902, 0.58039215686275, 0.56862745098039},
                    {0.75294117647059, 0.53725490196078, 0.52549019607843},
                    {0.72156862745098, 0.50196078431373, 0.49019607843137},
                    {0.69019607843137, 0.46666666666667, 0.45490196078431},
                    {0.65490196078431, 0.43921568627451, 0.41960784313725},
                    {0.62745098039216, 0.4156862745098, 0.38823529411765},
                    {0.59607843137255, 0.3921568627451, 0.35686274509804},
                    {0.56862745098039, 0.37254901960784, 0.33333333333333},
                    {0.54117647058824, 0.35294117647059, 0.30588235294118},
                    {0.51764705882353, 0.32941176470588, 0.28627450980392},
                    {0.49411764705882, 0.30980392156863, 0.26666666666667},
                    {0.47058823529412, 0.29019607843137, 0.24705882352941},
                    {0.45490196078431, 0.27450980392157, 0.23137254901961},
            },
            {
                    {0.92549019607843, 0.86274509803922, 0.74117647058824},
                    {0.92156862745098, 0.85882352941176, 0.73725490196078},
                    {0.91372549019608, 0.83529411764706, 0.72549019607843},
                    {0.89019607843137, 0.7921568627451, 0.69803921568627},
                    {0.86666666666667, 0.73725490196078, 0.66666666666667},
                    {0.83529411764706, 0.67450980392157, 0.62745098039216},
                    {0.80392156862745, 0.61960784313725, 0.58823529411765},
                    {0.77647058823529, 0.57254901960784, 0.55294117647059},
                    {0.74509803921569, 0.52941176470588, 0.51372549019608},
                    {0.71372549019608, 0.49411764705882, 0.48235294117647},
                    {0.68235294117647, 0.46274509803922, 0.44313725490196},
                    {0.65098039215686, 0.43529411764706, 0.41176470588235},
                    {0.61960784313725, 0.41176470588235, 0.38039215686275},
                    {0.5921568627451, 0.38823529411765, 0.35294117647059},
                    {0.56470588235294, 0.36862745098039, 0.32941176470588},
                    {0.53725490196078, 0.34901960784314, 0.30196078431373},
                    {0.51372549019608, 0.32941176470588, 0.28235294117647},
                    {0.49019607843137, 0.30980392156863, 0.26274509803922},
                    {0.47058823529412, 0.29019607843137, 0.24313725490196},
                    {0.45098039215686, 0.27058823529412, 0.22745098039216},
            },
            {
                    {0.90196078431373, 0.82352941176471, 0.68627450980392},
                    {0.89803921568627, 0.81960784313725, 0.68627450980392},
                    {0.89019607843137, 0.8, 0.67450980392157},
                    {0.87058823529412, 0.75686274509804, 0.65098039215686},
                    {0.84705882352941, 0.70980392156863, 0.62745098039216},
                    {0.8156862745098, 0.65098039215686, 0.5921568627451},
                    {0.78823529411765, 0.6, 0.56078431372549},
                    {0.76078431372549, 0.55294117647059, 0.52941176470588},
                    {0.72941176470588, 0.51372549019608, 0.49411764705882},
                    {0.69803921568627, 0.48235294117647, 0.46274509803922},
                    {0.66666666666667, 0.45098039215686, 0.42745098039216},
                    {0.63529411764706, 0.42745098039216, 0.39607843137255},
                    {0.6078431372549, 0.40392156862745, 0.37254901960784},
                    {0.58039215686275, 0.38039215686275, 0.34117647058824},
                    {0.55294117647059, 0.36470588235294, 0.32156862745098},
                    {0.52941176470588, 0.34117647058824, 0.29803921568627},
                    {0.50588235294118, 0.32156862745098, 0.27450980392157},
                    {0.48235294117647, 0.30588235294118, 0.25490196078431},
                    {0.46274509803922, 0.28627450980392, 0.23921568627451},
                    {0.44313725490196, 0.26666666666667, 0.22352941176471},
            },
            {
                    {0.86274509803922, 0.76862745098039, 0.6156862745098},
                    {0.86274509803922, 0.76078431372549, 0.6156862745098},
                    {0.85490196078431, 0.74509803921569, 0.6078431372549},
                    {0.83529411764706, 0.70980392156863, 0.5921568627451},
                    {0.8156862745098, 0.66666666666667, 0.56862745098039},
                    {0.78823529411765, 0.6156862745098, 0.54509803921569},
                    {0.76078431372549, 0.56862745098039, 0.51764705882353},
                    {0.73333333333333, 0.52941176470588, 0.49019607843137},
                    {0.70588235294118, 0.49411764705882, 0.46274509803922},
                    {0.67843137254902, 0.46274509803922, 0.43529411764706},
                    {0.64705882352941, 0.43529411764706, 0.4078431372549},
                    {0.61960784313725, 0.41176470588235, 0.37647058823529},
                    {0.5921568627451, 0.3921568627451, 0.35294117647059},
                    {0.56470588235294, 0.37254901960784, 0.32941176470588},
                    {0.54117647058824, 0.35294117647059, 0.30588235294118},
                    {0.51372549019608, 0.33333333333333, 0.28627450980392},
                    {0.49411764705882, 0.31372549019608, 0.26666666666667},
                    {0.47058823529412, 0.29803921568627, 0.24705882352941},
                    {0.45098039215686, 0.27843137254902, 0.23137254901961},
                    {0.43529411764706, 0.26274509803922, 0.2156862745098},
            },
            {
                    {0.81960784313725, 0.70196078431373, 0.54117647058824},
                    {0.8156862745098, 0.69803921568627, 0.54117647058824},
                    {0.8078431372549, 0.68235294117647, 0.53333333333333},
                    {0.7921568627451, 0.65490196078431, 0.52549019607843},
                    {0.77254901960784, 0.6156862745098, 0.50980392156863},
                    {0.74901960784314, 0.57254901960784, 0.49019607843137},
                    {0.72549019607843, 0.53333333333333, 0.47058823529412},
                    {0.70196078431373, 0.49803921568627, 0.44705882352941},
                    {0.67450980392157, 0.46666666666667, 0.42352941176471},
                    {0.64705882352941, 0.43921568627451, 0.40392156862745},
                    {0.61960784313725, 0.4156862745098, 0.37647058823529},
                    {0.5921568627451, 0.3921568627451, 0.35294117647059},
                    {0.56862745098039, 0.37647058823529, 0.33333333333333},
                    {0.54509803921569, 0.35686274509804, 0.30980392156863},
                    {0.52156862745098, 0.34117647058824, 0.29019607843137},
                    {0.49803921568627, 0.32156862745098, 0.27058823529412},
                    {0.47450980392157, 0.30196078431373, 0.25098039215686},
                    {0.45882352941176, 0.28627450980392, 0.23529411764706},
                    {0.43921568627451, 0.27058823529412, 0.21960784313725},
                    {0.42352941176471, 0.25490196078431, 0.2078431372549},
            },
            {
                    {0.75686274509804, 0.62352941176471, 0.46274509803922},
                    {0.75686274509804, 0.62352941176471, 0.46274509803922},
                    {0.74901960784314, 0.61176470588235, 0.45882352941176},
                    {0.73725490196078, 0.58823529411765, 0.45098039215686},
                    {0.72156862745098, 0.55686274509804, 0.44313725490196},
                    {0.69803921568627, 0.52156862745098, 0.43137254901961},
                    {0.67843137254902, 0.48627450980392, 0.4156862745098},
                    {0.65490196078431, 0.45882352941176, 0.4},
                    {0.63137254901961, 0.43137254901961, 0.38039215686275},
                    {0.6078431372549, 0.41176470588235, 0.36470588235294},
                    {0.5843137254902, 0.38823529411765, 0.34509803921569},
                    {0.56078431372549, 0.37254901960784, 0.32549019607843},
                    {0.53725490196078, 0.35294117647059, 0.30588235294118},
                    {0.51764705882353, 0.33725490196078, 0.28627450980392},
                    {0.49411764705882, 0.32156862745098, 0.27058823529412},
                    {0.47450980392157, 0.30588235294118, 0.25098039215686},
                    {0.45490196078431, 0.29019607843137, 0.23529411764706},
                    {0.43921568627451, 0.27450980392157, 0.22352941176471},
                    {0.41960784313725, 0.25882352941176, 0.2078431372549},
                    {0.4078431372549, 0.24313725490196, 0.19607843137255},
            },
            {
                    {0.69411764705882, 0.54901960784314, 0.3921568627451},
                    {0.69411764705882, 0.54901960784314, 0.3921568627451},
                    {0.69019607843137, 0.53725490196078, 0.3921568627451},
                    {0.67843137254902, 0.52156862745098, 0.38823529411765},
                    {0.66274509803922, 0.49803921568627, 0.38039215686275},
                    {0.64705882352941, 0.47058823529412, 0.37254901960784},
                    {0.62745098039216, 0.44313725490196, 0.36470588235294},
                    {0.6078431372549, 0.41960784313725, 0.35294117647059},
                    {0.58823529411765, 0.39607843137255, 0.33725490196078},
                    {0.56862745098039, 0.38039215686275, 0.32549019607843},
                    {0.54509803921569, 0.36078431372549, 0.30980392156863},
                    {0.52549019607843, 0.34509803921569, 0.29411764705882},
                    {0.50588235294118, 0.32941176470588, 0.27843137254902},
                    {0.48627450980392, 0.31764705882353, 0.26274509803922},
                    {0.46666666666667, 0.30196078431373, 0.24705882352941},
                    {0.44705882352941, 0.29019607843137, 0.23137254901961},
                    {0.43137254901961, 0.27450980392157, 0.21960784313725},
                    {0.4156862745098, 0.25882352941176, 0.2078431372549},
                    {0.4, 0.24705882352941, 0.1921568627451},
                    {0.38823529411765, 0.23137254901961, 0.1843137254902},
            },
            {
                    {0.62352941176471, 0.47450980392157, 0.32941176470588},
                    {0.62352941176471, 0.47058823529412, 0.32941176470588},
                    {0.61960784313725, 0.46666666666667, 0.32941176470588},
                    {0.6078431372549, 0.45098039215686, 0.32549019607843},
                    {0.6, 0.43529411764706, 0.32549019607843},
                    {0.5843137254902, 0.41176470588235, 0.31764705882353},
                    {0.56862745098039, 0.3921568627451, 0.31372549019608},
                    {0.55294117647059, 0.37647058823529, 0.30588235294118},
                    {0.53333333333333, 0.35686274509804, 0.29411764705882},
                    {0.51764705882353, 0.34509803921569, 0.28627450980392},
                    {0.50196078431373, 0.32941176470588, 0.27450980392157},
                    {0.48235294117647, 0.31764705882353, 0.25882352941176},
                    {0.46666666666667, 0.30588235294118, 0.24705882352941},
                    {0.44705882352941, 0.29019607843137, 0.23529411764706},
                    {0.43137254901961, 0.28235294117647, 0.22352941176471},
                    {0.4156862745098, 0.26666666666667, 0.21176470588235},
                    {0.4, 0.25490196078431, 0.2},
                    {0.38823529411765, 0.24313725490196, 0.18823529411765},
                    {0.37254901960784, 0.23137254901961, 0.17647058823529},
                    {0.36470588235294, 0.21960784313725, 0.16862745098039},
            },
            {
                    {0.54901960784314, 0.40392156862745, 0.27843137254902},
                    {0.54901960784314, 0.4, 0.27843137254902},
                    {0.54509803921569, 0.39607843137255, 0.27843137254902},
                    {0.54117647058824, 0.38823529411765, 0.27450980392157},
                    {0.52941176470588, 0.37647058823529, 0.27450980392157},
                    {0.52156862745098, 0.36078431372549, 0.27058823529412},
                    {0.50588235294118, 0.34509803921569, 0.26666666666667},
                    {0.49411764705882, 0.33333333333333, 0.26274509803922},
                    {0.48235294117647, 0.31764705882353, 0.25490196078431},
                    {0.46666666666667, 0.30980392156863, 0.24705882352941},
                    {0.45098039215686, 0.29803921568627, 0.23921568627451},
                    {0.43921568627451, 0.28627450980392, 0.22745098039216},
                    {0.42352941176471, 0.27843137254902, 0.21960784313725},
                    {0.4078431372549, 0.26666666666667, 0.2078431372549},
                    {0.39607843137255, 0.25490196078431, 0.2},
                    {0.3843137254902, 0.24705882352941, 0.18823529411765},
                    {0.36862745098039, 0.23529411764706, 0.18039215686275},
                    {0.35686274509804, 0.22352941176471, 0.17254901960784},
                    {0.34509803921569, 0.21176470588235, 0.16078431372549},
                    {0.33725490196078, 0.20392156862745, 0.15294117647059},
            },
            {
                    {0.47843137254902, 0.34509803921569, 0.23137254901961},
                    {0.47843137254902, 0.34117647058824, 0.23137254901961},
                    {0.48235294117647, 0.34117647058824, 0.23137254901961},
                    {0.47058823529412, 0.32941176470588, 0.23137254901961},
                    {0.47058823529412, 0.32549019607843, 0.23137254901961},
                    {0.45490196078431, 0.30980392156863, 0.23137254901961},
                    {0.44705882352941, 0.30196078431373, 0.22745098039216},
                    {0.43921568627451, 0.29019607843137, 0.22352941176471},
                    {0.42745098039216, 0.28235294117647, 0.21960784313725},
                    {0.41960784313725, 0.27450980392157, 0.21176470588235},
                    {0.4078431372549, 0.26666666666667, 0.2078431372549},
                    {0.3921568627451, 0.25490196078431, 0.2},
                    {0.3843137254902, 0.24705882352941, 0.1921568627451},
                    {0.37254901960784, 0.23921568627451, 0.1843137254902},
                    {0.35686274509804, 0.23137254901961, 0.17647058823529},
                    {0.34509803921569, 0.22352941176471, 0.16862745098039},
                    {0.33725490196078, 0.2156862745098, 0.16078431372549},
                    {0.32549019607843, 0.20392156862745, 0.15294117647059},
                    {0.31764705882353, 0.19607843137255, 0.14509803921569},
                    {0.30980392156863, 0.18823529411765, 0.13725490196078},
            },
            {
                    {0.4156862745098, 0.29019607843137, 0.2},
                    {0.4156862745098, 0.29019607843137, 0.2},
                    {0.4156862745098, 0.28627450980392, 0.2},
                    {0.41176470588235, 0.28235294117647, 0.2},
                    {0.4078431372549, 0.27843137254902, 0.19607843137255},
                    {0.4, 0.27058823529412, 0.19607843137255},
                    {0.3921568627451, 0.26274509803922, 0.19607843137255},
                    {0.3843137254902, 0.25490196078431, 0.1921568627451},
                    {0.37647058823529, 0.24705882352941, 0.18823529411765},
                    {0.36862745098039, 0.24313725490196, 0.1843137254902},
                    {0.35686274509804, 0.23529411764706, 0.18039215686275},
                    {0.34901960784314, 0.23137254901961, 0.17647058823529},
                    {0.34117647058824, 0.22352941176471, 0.16862745098039},
                    {0.32941176470588, 0.2156862745098, 0.16470588235294},
                    {0.32156862745098, 0.21176470588235, 0.15686274509804},
                    {0.31372549019608, 0.20392156862745, 0.14901960784314},
                    {0.30588235294118, 0.19607843137255, 0.14509803921569},
                    {0.29803921568627, 0.18823529411765, 0.13725490196078},
                    {0.29019607843137, 0.18039215686275, 0.12941176470588},
                    {0.28235294117647, 0.17254901960784, 0.12549019607843},
            },
            {
                    {0.36078431372549, 0.24705882352941, 0.16862745098039},
                    {0.36078431372549, 0.24705882352941, 0.16862745098039},
                    {0.35686274509804, 0.24313725490196, 0.16862745098039},
                    {0.35686274509804, 0.24313725490196, 0.16862745098039},
                    {0.35294117647059, 0.23921568627451, 0.16862745098039},
                    {0.34901960784314, 0.23137254901961, 0.16862745098039},
                    {0.34117647058824, 0.22745098039216, 0.16862745098039},
                    {0.33725490196078, 0.22352941176471, 0.16470588235294},
                    {0.32941176470588, 0.21960784313725, 0.16470588235294},
                    {0.32549019607843, 0.2156862745098, 0.16078431372549},
                    {0.31764705882353, 0.2078431372549, 0.15686274509804},
                    {0.30980392156863, 0.20392156862745, 0.15294117647059},
                    {0.30196078431373, 0.2, 0.14901960784314},
                    {0.29411764705882, 0.19607843137255, 0.14117647058824},
                    {0.29019607843137, 0.18823529411765, 0.13725490196078},
                    {0.28235294117647, 0.1843137254902, 0.13333333333333},
                    {0.27450980392157, 0.17647058823529, 0.12549019607843},
                    {0.26666666666667, 0.16862745098039, 0.12156862745098},
                    {0.26274509803922, 0.16470588235294, 0.11764705882353},
                    {0.25490196078431, 0.15686274509804, 0.11372549019608},
            },
            {
                    {0.30588235294118, 0.2078431372549, 0.14509803921569},
                    {0.30588235294118, 0.2078431372549, 0.14509803921569},
                    {0.30588235294118, 0.2078431372549, 0.14509803921569},
                    {0.30588235294118, 0.20392156862745, 0.14509803921569},
                    {0.30196078431373, 0.20392156862745, 0.14509803921569},
                    {0.29803921568627, 0.2, 0.14509803921569},
                    {0.29411764705882, 0.19607843137255, 0.14117647058824},
                    {0.29019607843137, 0.1921568627451, 0.14117647058824},
                    {0.28627450980392, 0.1921568627451, 0.14117647058824},
                    {0.28235294117647, 0.18823529411765, 0.13725490196078},
                    {0.27450980392157, 0.1843137254902, 0.13333333333333},
                    {0.27058823529412, 0.18039215686275, 0.13333333333333},
                    {0.26666666666667, 0.17647058823529, 0.12941176470588},
                    {0.25882352941176, 0.17254901960784, 0.12549019607843},
                    {0.25490196078431, 0.16862745098039, 0.12156862745098},
                    {0.25098039215686, 0.16470588235294, 0.11764705882353},
                    {0.24313725490196, 0.15686274509804, 0.11372549019608},
                    {0.23921568627451, 0.15294117647059, 0.10980392156863},
                    {0.23529411764706, 0.14509803921569, 0.10196078431373},
                    {0.22745098039216, 0.14117647058824, 0.098039215686275},
            },
            {
                    {0.26274509803922, 0.17647058823529, 0.12156862745098},
                    {0.26274509803922, 0.17647058823529, 0.12156862745098},
                    {0.26274509803922, 0.17647058823529, 0.12156862745098},
                    {0.25882352941176, 0.17647058823529, 0.12156862745098},
                    {0.25882352941176, 0.17254901960784, 0.12156862745098},
                    {0.25490196078431, 0.17254901960784, 0.12156862745098},
                    {0.25490196078431, 0.16862745098039, 0.12156862745098},
                    {0.25098039215686, 0.16862745098039, 0.12156862745098},
                    {0.24705882352941, 0.16470588235294, 0.12156862745098},
                    {0.24313725490196, 0.16470588235294, 0.11764705882353},
                    {0.23921568627451, 0.16078431372549, 0.11764705882353},
                    {0.23529411764706, 0.15686274509804, 0.11372549019608},
                    {0.23137254901961, 0.15686274509804, 0.10980392156863},
                    {0.22745098039216, 0.15294117647059, 0.10980392156863},
                    {0.22352941176471, 0.14901960784314, 0.10588235294118},
                    {0.21960784313725, 0.14509803921569, 0.10196078431373},
                    {0.2156862745098, 0.14117647058824, 0.098039215686275},
                    {0.21176470588235, 0.13725490196078, 0.094117647058824},
                    {0.2078431372549, 0.13333333333333, 0.090196078431373},
                    {0.20392156862745, 0.12549019607843, 0.090196078431373},
            },
            {
                    {0.22352941176471, 0.15294117647059, 0.10588235294118},
                    {0.22352941176471, 0.15294117647059, 0.10588235294118},
                    {0.22352941176471, 0.15294117647059, 0.10588235294118},
                    {0.22352941176471, 0.15294117647059, 0.10588235294118},
                    {0.21960784313725, 0.14901960784314, 0.10588235294118},
                    {0.21960784313725, 0.14901960784314, 0.10588235294118},
                    {0.21960784313725, 0.14901960784314, 0.10588235294118},
                    {0.2156862745098, 0.14509803921569, 0.10588235294118},
                    {0.21176470588235, 0.14509803921569, 0.10196078431373},
                    {0.21176470588235, 0.14117647058824, 0.10196078431373},
                    {0.2078431372549, 0.14117647058824, 0.10196078431373},
                    {0.20392156862745, 0.13725490196078, 0.098039215686275},
                    {0.20392156862745, 0.13725490196078, 0.098039215686275},
                    {0.2, 0.13333333333333, 0.094117647058824},
                    {0.19607843137255, 0.13333333333333, 0.090196078431373},
                    {0.1921568627451, 0.12941176470588, 0.090196078431373},
                    {0.1921568627451, 0.12549019607843, 0.086274509803922},
                    {0.18823529411765, 0.12156862745098, 0.082352941176471},
                    {0.1843137254902, 0.11764705882353, 0.082352941176471},
                    {0.18039215686275, 0.11372549019608, 0.07843137254902},
            },
            {
                    {0.1921568627451, 0.13333333333333, 0.090196078431373},
                    {0.1921568627451, 0.13333333333333, 0.090196078431373},
                    {0.1921568627451, 0.13333333333333, 0.090196078431373},
                    {0.1921568627451, 0.12941176470588, 0.090196078431373},
                    {0.1921568627451, 0.12941176470588, 0.090196078431373},
                    {0.1921568627451, 0.12941176470588, 0.090196078431373},
                    {0.18823529411765, 0.12941176470588, 0.090196078431373},
                    {0.18823529411765, 0.12941176470588, 0.090196078431373},
                    {0.18823529411765, 0.12549019607843, 0.090196078431373},
                    {0.1843137254902, 0.12549019607843, 0.090196078431373},
                    {0.1843137254902, 0.12549019607843, 0.086274509803922},
                    {0.18039215686275, 0.12156862745098, 0.086274509803922},
                    {0.18039215686275, 0.12156862745098, 0.086274509803922},
                    {0.17647058823529, 0.11764705882353, 0.082352941176471},
                    {0.17254901960784, 0.11764705882353, 0.082352941176471},
                    {0.17254901960784, 0.11372549019608, 0.07843137254902},
                    {0.16862745098039, 0.10980392156863, 0.074509803921569},
                    {0.16862745098039, 0.10980392156863, 0.074509803921569},
                    {0.16470588235294, 0.10588235294118, 0.070588235294118},
                    {0.16078431372549, 0.10196078431373, 0.070588235294118},
            },
            {
                    {0.16862745098039, 0.11372549019608, 0.07843137254902},
                    {0.16862745098039, 0.11372549019608, 0.07843137254902},
                    {0.16862745098039, 0.11372549019608, 0.07843137254902},
                    {0.16862745098039, 0.11372549019608, 0.07843137254902},
                    {0.16862745098039, 0.11372549019608, 0.07843137254902},
                    {0.16470588235294, 0.11372549019608, 0.07843137254902},
                    {0.16470588235294, 0.11372549019608, 0.07843137254902},
                    {0.16470588235294, 0.11372549019608, 0.07843137254902},
                    {0.16470588235294, 0.11372549019608, 0.07843137254902},
                    {0.16078431372549, 0.10980392156863, 0.07843137254902},
                    {0.16078431372549, 0.10980392156863, 0.074509803921569},
                    {0.16078431372549, 0.10980392156863, 0.074509803921569},
                    {0.15686274509804, 0.10588235294118, 0.074509803921569},
                    {0.15686274509804, 0.10588235294118, 0.070588235294118},
                    {0.15294117647059, 0.10196078431373, 0.070588235294118},
                    {0.15294117647059, 0.10196078431373, 0.070588235294118},
                    {0.14901960784314, 0.098039215686275, 0.066666666666667},
                    {0.14901960784314, 0.098039215686275, 0.066666666666667},
                    {0.14901960784314, 0.094117647058824, 0.062745098039216},
                    {0.14509803921569, 0.094117647058824, 0.062745098039216},
            },
            {
                    {0.14509803921569, 0.10196078431373, 0.070588235294118},
                    {0.14509803921569, 0.10196078431373, 0.070588235294118},
                    {0.14509803921569, 0.10196078431373, 0.070588235294118},
                    {0.14509803921569, 0.10196078431373, 0.070588235294118},
                    {0.14509803921569, 0.098039215686275, 0.070588235294118},
                    {0.14509803921569, 0.098039215686275, 0.066666666666667},
                    {0.14509803921569, 0.098039215686275, 0.066666666666667},
                    {0.14509803921569, 0.098039215686275, 0.066666666666667},
                    {0.14117647058824, 0.098039215686275, 0.066666666666667},
                    {0.14117647058824, 0.098039215686275, 0.066666666666667},
                    {0.14117647058824, 0.098039215686275, 0.066666666666667},
                    {0.14117647058824, 0.094117647058824, 0.066666666666667},
                    {0.13725490196078, 0.094117647058824, 0.062745098039216},
                    {0.13725490196078, 0.094117647058824, 0.062745098039216},
                    {0.13725490196078, 0.090196078431373, 0.062745098039216},
                    {0.13333333333333, 0.090196078431373, 0.062745098039216},
                    {0.13333333333333, 0.090196078431373, 0.058823529411765},
                    {0.13333333333333, 0.086274509803922, 0.058823529411765},
                    {0.12941176470588, 0.086274509803922, 0.054901960784314},
                    {0.12941176470588, 0.082352941176471, 0.054901960784314},
            }
    });
}