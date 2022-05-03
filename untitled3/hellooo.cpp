#include <iostream>
#include <vector>
using namespace std;
class Vehicles{
	protected:
		int tocdo;
	public:
		Vehicles();
		Vehicles(int tocdo);
		virtual int const maxSpeed()=0;
		virtual void Nhap();
		virtual	void Xuat();
};
Vehicles::Vehicles(){
	tocdo=0;
}
Vehicles::Vehicles(int tocdo){
	this->tocdo=tocdo;
}
void Vehicles::Nhap(){
	cout<<"Toc do tieu chuan: ";
	cin>>this->tocdo;
}
void Vehicles::Xuat(){
	cout<<this->tocdo<<"\t";
}
class Ferrari : public Vehicles{
	private:
		string mausac;
		double hesotocdo;
	public:
		Ferrari();
		Ferrari(string mausac,double hesotocdo);
		void Nhap();
		void Xuat();
		int const maxSpeed();
		friend bool operator>(Ferrari &s1,Ferrari &s2);
};
bool operator>(Ferrari &s1,Ferrari &s2){
	if(s1.maxSpeed() > s2.maxSpeed()){
		return true;
	}
	return false;
}
Ferrari::Ferrari():Vehicles(){
	mausac="";
	hesotocdo=0;
}
Ferrari::Ferrari(string mausac,double hesotocdo):Vehicles(tocdo){
	this->mausac=mausac;
	this->hesotocdo=hesotocdo;
}
void Ferrari::Nhap(){
	Vehicles::Nhap();
	cout<<"Nhap mau sac: ";
	cin>>this->mausac;
	cout<<"Nhap he so toc do: ";
	cin>>this->hesotocdo;
}
void Ferrari::Xuat(){
	Vehicles::Xuat();
	cout<<this->mausac<<"\t"<<this->hesotocdo<<"\t"<<this->maxSpeed()<<endl;
}
int const Ferrari::maxSpeed(){
	return this->hesotocdo*this->tocdo;
}
int main(){
	vector<Vehicles*> dsxe;
	Vehicles *x;
	
	cout << "Nhap so xe: ";
        int n;
        cin >> n;
        for (int i = 0; i < n; i++)
        {
            cout << "Xe Ferrari(1): ";
            int k;
            cin >> k;
            // Tuy vào nguoi dung chon doi tuong nao de nhap
            if (k == 1)
                x = new Ferrari;
           		 x->Nhap(); // da hinh
           		 dsxe.push_back(x);
        }
   cout<<"Danh sach xe: \n";
        for (int i = 0; i < dsxe.size(); i++)
        {
            cout << "STT:" << i + 1 << endl;
            dsxe.at(i)->Xuat(); //da hinh
        }
    cout<<"Xe Ferrari co toc do toi da lon nhat \n";
    for (int i = 0; i < dsxe.size(); i++)
        {
        	for(int j=0;i<dsxe.size();i++){
        		if(dsxe.at(i) > dsxe.at(j)){
        			cout<<"Xe co toc do lon nhat la xe co MaxSpeed la: "<<dsxe.at(i)->maxSpeed()<<endl;
				}
			}
        }
    return 0;
}








