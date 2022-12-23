import java.util.Scanner;// библ для ввода с клавиатуры


class Complex {

    private double re = 0;
    private double im = 0;
    private double arg = 0;
    private double mod = 0;
    private   short loc =0;
    private  String format = "alg";

    //////////////////////////////////////////////////////конструкторы
    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
        arg=GetArg();
        mod=Math.pow(re*re+im*im,0.5);
        format = "alg";

    }
    public Complex() {
        this.re = 0;
        this.im = 0;

    }
    ///////////////////////////////////////////////////конструкторы

    ///////////////////////////////////////////////////////////////////// поля начало
    ////////////////////////////// статические
    ////////////////////////////// статические
    ////////////////////////////// гетеры и сетеры
    ////////////////////////////// гетеры и сетеры

    //////////////////////////////////////////////////////////////////// поля конец

    ///////////////////////////////////////////////////////////функции
    public static Complex Sum(Complex z, Complex w) {

        return new Complex(z.re + w.re, z.im + w.im);
    }
    public static Complex Sum(Complex z, double a) {

        return new Complex(z.re +a, z.im );
    }
    public static Complex Sum( double a,Complex z) {

        return  Sum(z,a);
    }

    public static Complex Sub(Complex z, Complex w) {

        return new Complex(z.re - w.re, z.im - w.im);
    }
    public static Complex Sub(Complex z, double a) {

        return new Complex(z.re +a, z.im );
    }
    public static Complex Sub( double a,Complex z) {

        return  Sub(z,a);
    }
    public static Complex Product(Complex z, Complex w) {

        Complex x = new Complex();

        x.re = z.re * w.re - z.im * w.im;
        x.im = z.re * w.im + z.im * w.re;
        return x;
    }
    public static Complex Product(double a, Complex z) {

        Complex x = new Complex();

        x.re = z.re * a;
        x.im = z.im * a;
        return x;
    }
    public static Complex Product(Complex z, double a)
    {
        return Product(a,z);
    }

    public static Complex Div(Complex z, Complex w) {

        Complex x = new Complex();
        double d=Math.pow(Mod(w),2);
        x=Product(z,Product(Con(w),1/d));

        return x;
    }
    public static Complex Div(Complex z, double a) {

        Complex x = new Complex();
        x=Product(z,1/a);
        return x;
    }
    public static Complex Div( double a,Complex z) {
        return Div(z,a);

    }

    public static Complex Pow(Complex z, double n) {

        Complex x = new Complex();
        x.arg=z.arg*n;
        x.mod=Math.pow(z.mod,n);
        x.re=x.mod*Math.cos(x.arg);
        x.im=x.mod*Math.sin(x.arg);
        return x;
    }



    public  static Complex Con(Complex z)
    {

        Complex x = new Complex();

        x.re = z.re;
        x.im = -z.im;
        return x;
    }
    static public double Mod(Complex z)
    {

        double x = Math.pow(z.re* z.re + z.im*z.im, 0.5);
        return x;
    }
    //////////////////////////////Методы гетеры и сетеры начало
    public  double GetRe() // как сделать без скобок???????????????????????????????????????????????????????????????
    {
        return re;
    }
    public  double GetIm() {
        return im;
    }
    public  void SetRe(double re)
    {
        this.re=re;
        mod=Math.pow(re*re+im*im,0.5);
        arg=GetArg();
    }
    public void SetIm(double im)
    {
        this.im=im;
        mod=Math.pow(re*re+im*im,0.5);
        arg=GetArg();
    }
    public  double GetArg()
    {
        return  Arg(re,im);
    }
    public  double GetMod() {
        Complex z = new Complex(re, im);  // как получить не создавая экземпляр класса??????????????????????????????
        return Mod(z);
    }
    public  void SetArg(double arg)
    {
        this.arg=arg;
        re=Math.cos(arg)*mod;
        im=Math.sin(arg)*mod;
    }
    public void SetMod(double mod)
    {
        this.mod=mod;
        re=Math.cos(arg)*mod;
        im=Math.sin(arg)*mod;
    }
    public  short GetLoc()
    {
        Complex z = new Complex(re, im);
        return Loc(z);
    }

    //////////////////////////////Методы гетеры и сетеры конец
    ////////////// вспомогательные методы
    public short Loc(Complex z)
    {
        if(z.re>0&&z.im>=0){return 1;}
        if(z.re<=0&&z.im>0){return 2;}
        if(z.re< 0&&z.im<=0){return 3;}
        if(z.re>=0&&z.im<0){return 4;}
        return 0;
    }
    private short Loc(double re,double im)
    {
        if(re>0&&im>=0){return 1;}
        if(re<=0&&im>0){return 2;}
        if(re< 0&&im<=0){return 3;}
        if(re>=0&&im<0){return 4;}
        return 0;
    }
    public  double Arg(Complex z)
    {
        if (z.re==0&&z.im>0){return Math.PI/2;}
        if (z.re==0&&z.im<0){return 3*Math.PI/2;}
        if (z.re==0&&z.im==0){return 0;}//сдесь нужно вызвать ошибку??????????????????????????????????????????????????
        double a =Math.atan(Math.abs(z.im/z.re));
        double b= a+ (Math.PI/2)*(Loc(z)-1);
        return b;
    }
    private   double Arg(double re,double im)
    {
        if (re==0&&im>0){return Math.PI/2;}
        if (re==0&&im<0){return 3*Math.PI/2;}
        if (re==0&&im==0){return 0;}//сдесь нужно вызвать ошибку??????????????????????????????????????????????????
        double a =Math.atan(Math.abs(im/re));
        double b= a+ (Math.PI/2)*(Loc(re,im)-1);
        return b;
    }
    public void ConvertToPollar()
    {
        format="pol";
    }
    public void ConvertToAlgebraic()
    {
        format="alg";
    }
    public void ConvertToExp()
    {
        format="exp";
    }



    ////////////// вспомогательные методы
    ///////////////////////////////////////////////////////////функции

    /////////////////////////////////// методы для вывода

    public String toString() {

        if (format == "alg") {
            if (re == 0 && im != 0) {
                {
                    return im + "i";
                }
            }
            if (re != 0 && im == 0) {
                return re + "";
            }
            if (re == 0 && im == 0) {
                return 0 + "";
            }
            if (im < 0) {
                return re + "-" + -im + "i";
            }
            return re + "+" + im + "i";
        }

        if (format == "pol") {

            return mod+" *[cos(" + arg + ") + i*"+"sin("+arg+")]";
        }


        return mod + " * EXP( i*"+arg/Math.PI+"π)";




    }

    /////////////////////////////////// методы для вывода


}


public class Main {

    static   void Test(Complex z,Complex w)
    {

        {
            System.out.println();
            System.out.println("Сумма");
            System.out.print(Complex.Sum(z,w));
        }
        {
            System.out.println();
            System.out.println("Разность");
            System.out.print(Complex.Sub(z,w));
        }
        {
            System.out.println();
            System.out.println("Произведение");
            System.out.print(Complex.Product(z,w));
        }
        {
            System.out.println();
            System.out.println("Отношение");
            System.out.print(Complex.Div(z,w));
        }
        {
            System.out.println();
            System.out.println("квадрат числа z");
            System.out.print(z.Pow(z,2));
        }
        {
            System.out.println();
            System.out.println("Действительная часть z ");
            System.out.println(z.GetRe());
        }
        {
            System.out.println();
            System.out.println("Мнимая часть z ");
            System.out.println(z.GetIm());
        }
        {
            System.out.println();
            System.out.println("Тригонометрическа форма числа");
           z.ConvertToPollar();
            System.out.println(z);
        }
        {
            System.out.println();
            System.out.println("Полярная форма числа z ");
            z.ConvertToExp();
            System.out.println(z);
        }
    }


    private static Scanner inn = new Scanner(System.in);// метод для ввода с клавиатуры

    public static <string> void main(String[] args) {


        Complex z =new Complex(1,1);
        Complex w =new Complex(2,-1);

        Test(z,w);

    }
}
